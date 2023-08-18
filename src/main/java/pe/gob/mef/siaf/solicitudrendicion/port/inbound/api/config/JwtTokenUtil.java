package pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil implements Serializable {

  private static final long serialVersionUID = -2550185165626007488L;

  public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

  @Value("${jwt.secret}")
  private String secret;

  public String getUsernameFromToken(String token) {
    // return getClaimFromToken(token, Claims::getSubject);
    @SuppressWarnings("deprecation")
    final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); 
    return claims.getSubject(); 
  }

  public Date getExpirationDateFromToken(String token) {
    // return getClaimFromToken(token, Claims::getExpiration);
    @SuppressWarnings("deprecation")
    final Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody(); 
    return claims.getExpiration();
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    return (Claims) Jwts.parserBuilder()
        .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret))).build()
        .parseClaimsJws(token);
    // return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }

  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();
    List<GrantedAuthority> grantedAuthorities =
        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"); 
    
    claims.put("authorities", grantedAuthorities.stream().map(GrantedAuthority::getAuthority)
        .collect(Collectors.toList()));
    
    return doGenerateToken(claims, userDetails.getUsername());
  }

  private String doGenerateToken(Map<String, Object> claims, String subject) {

    return Jwts.builder().setClaims(claims).setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
        .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret)), SignatureAlgorithm.HS256)
        // .signWith(SignatureAlgorithm.HS512, secret.getBytes())
        // .signWith(SignatureAlgorithm.HS256, secret)
        .compact();
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = getUsernameFromToken(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }

}
