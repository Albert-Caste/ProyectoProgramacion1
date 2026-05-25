package co.edu.uniquindio.parquederojfx.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Facturacion(LocalDate dia, LocalDateTime hora, Cliente cliente, Vehiculo vehiculo, double  tiempo, double totalPago ) {
    @Override
    public String toString() {
        return String.format(
                """
              
                  RESUMEN DE PAGO
                  
                  Fecha    : %s
                  Hora     : %s              
               
                  Documento    : %s
                  Nombre       : %s
                  Placa        : %s
                  Tiempo       : %s 
                  Tipo cliente : %s
                  Total Servicio : $%,.2f
               
                """,
                dia, hora, cliente.getDocumento(), cliente.getNombre(), vehiculo.getPlaca(),
                tiempo, cliente.getTipoUsuario(), totalPago
        );
    }

}
