package pe.edu.utp.service;
import org.springframework.stereotype.Service;
import pe.edu.utp.model.Configuracion;
@Service
public class ConfiguracionService {
 private final Configuracion configuracion = new Configuracion();
 public Configuracion obtener(){return configuracion;}
 public void guardar(Configuracion nueva){
   configuracion.setNombreBodega(nueva.getNombreBodega());
   configuracion.setMoneda(nueva.getMoneda());
   configuracion.setTema(nueva.getTema());
 }
}
