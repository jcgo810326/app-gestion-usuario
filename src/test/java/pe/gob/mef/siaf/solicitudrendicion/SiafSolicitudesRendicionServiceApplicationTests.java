package pe.gob.mef.siaf.solicitudrendicion;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import io.restassured.RestAssured;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarSolicitudRendicionCab;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarSolicitudRendicionDestino;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarSolicitudRendicionDet;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarSolicitudRendicionRequest;
import pe.gob.mef.siaf.solicitudrendicion.port.inbound.api.dto.RegistrarSolicitudRendicionSec;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    classes = RealmAuthServiceApplication.class)
@TestMethodOrder(OrderAnnotation.class)
class SiafSolicitudesRendicionServiceApplicationTests {

  @LocalServerPort
  private int port;

  private String token;
  
  @Value("${test.passkeyc}")
  private String password;

  @Value("${server.servlet.context-path}")
  private String basePath;
  
  private void inicializar() {
    RestAssured.reset();
    var responseToken = given()
        .formParam("grant_type", "password")
        .formParam("client_id", "jwtClient")
        .formParam("client_secret", "276432e6-f59a-482f-aead-6c57d0e7667e")
        .formParam("username", "RU22500")
        .formParam("password", this.password)
        .post("https://authorizedesa.mineco.gob.pe/auth/realms/mef/protocol/openid-connect/token")
        .then().statusCode(HttpStatus.OK.value()).extract().response();

    token = responseToken.jsonPath().getString("access_token");

    RestAssured.port = port;
    RestAssured.baseURI = "http://localhost";
    RestAssured.basePath = this.basePath;
  }
  
  @Test
  @Order(1)
  void obtenerSolicitudesRendicion() {
    this.inicializar();
    given().auth().oauth2(token).when().get(
        "/solicitudes-rendicion?anio=2023&page=0&page_size=10&sort=anio&mes=&expediente=&tipoSolicitud=&estadoRegistro=&fuenteFinanc=")
        .then().assertThat().statusCode(200);
  }
  
  @Test
  @Order(2)
  void obtenerSolicitudesRendicionDet() {
    this.inicializar();
    given().auth().oauth2(token).when().get("/solicitudes-rendicion-detalle/2023/4").then()
        .assertThat().statusCode(200);
  }
  
  @Test
  @Order(3)
  void obtenerSolicitudesRendicionExpMetaOrigen() {
    this.inicializar();
    given().auth().oauth2(token).when().get("/solicitudes-rendicion-expediente-meta?anio=2023&expediente=8&ciclo=G&fase=C").then()
        .assertThat().statusCode(200);
  }
  
  @Test
  @Order(4)
  void obtenerSolicitudesRendicionMarcoPresupuesto() {
    this.inicializar();
    given().auth().oauth2(token).when().get("/solicitudes-rendicion-marco-presupuesto?anio=2023&page=0&page_size=10&sort=anio").then()
        .assertThat().statusCode(200);
  }
  
  @Test
  @Order(5)
  void registrarSolicitudRendicion() {
    this.inicializar();

    var registrarSolicitudRendicionRequest = RegistrarSolicitudRendicionRequest.builder().anio(2023)
        .secuenciaSolicitud(182).secuenciaPorExpediente(1).idClasificador("ACJNeNa")
        .secuenciaFuncional(46).estadoRegistro("A").monto(Double.valueOf("134"))
        .montoNacional(Double.valueOf("134"))
        .solicitudRendicionCab(RegistrarSolicitudRendicionCab.builder().mesEjec(7).tipoSolicitud(1)
            .indicadorCertifica(null).tipoOperacion("AV").tipoRendicion(1).secuenciaNota(183)
            .build())
        .solicitudRendicionDet(RegistrarSolicitudRendicionDet.builder().expediente(1087).ciclo("G")
            .fase("G").correlativo(1).secuencia(3).secuenciaAnterior(2).secuenciaPadre(1)
            .certificado(56).certificadoSecuencia(1).fuenteFinanciamiento("00").moneda("S/.")
            .tipoCambio(Double.valueOf(1)).monto(Double.valueOf("150"))
            .montoNacional(Double.valueOf("134")).secuenciaSolicitudPadre(null)
            .tipoDocumentIdent("9").ruc(null).entidadReciproca(null).build())
        .solicitudRendicionDestino(RegistrarSolicitudRendicionDestino.builder()
            .idClasificadorDestino("ACJNeNa").secuenciaFuncionalDestino(46).build())
        .solicitudRendicionSec(RegistrarSolicitudRendicionSec.builder().correlativoSolicitud(1)
            .tipoRegistro(null).codigodocumento("048").numeroDocumento("IF025-2023-EF/45043")
            .fechaDocumento("20/06/2023").fechaRegistro("20/06/2023").fechaProceso("20/06/2023")
            .build())
        .build();

    given().auth().oauth2(token).contentType("application/json")
        .body(registrarSolicitudRendicionRequest).when().post("/solicitudes-rendicion").then()
        .assertThat().statusCode(201);
  }
  
  @Test
  @Order(6)
  void obtenerExpedienteSiaf() {
    this.inicializar();
    given().auth().oauth2(token).when().get("/expedientes-siaf?anio=2023&page=0&page_size=10&sort=expediente&ciclo=G&fase=C").then()
        .assertThat().statusCode(200);
  }
  
  @Test
  @Order(7)
  void obtenerExpedienteSiafDet() {
    this.inicializar();
    given().auth().oauth2(token).when().get("/expedientes-siaf-detalle/2023/272/G/C").then()
        .assertThat().statusCode(200);
  }
  
  @Test
  @Order(8)
  void obtenerSolicitudesReasignacion() {
    this.inicializar();
    given().auth().oauth2(token).when().get("/solicitudes-reasignacion?anio=2023&page=0&page_size=10&sort=anio&mes=&expediente=&tipoSolicitud=2&estado=&fuenteFinanc=").then()
        .assertThat().statusCode(200);
  }
  
  @Test
  @Order(9)
  void obtenerSolicitudesReasignacionDet() {
    this.inicializar();
    given().auth().oauth2(token).when().get("/solicitudes-reasignacion-detalle/2023/2/19").then()
        .assertThat().statusCode(200);
  }  

}
