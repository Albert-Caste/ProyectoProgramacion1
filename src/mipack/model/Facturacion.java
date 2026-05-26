package mipack.model;
import java.time.LocalDateTime;

public record Facturacion(
        String numeroFactura,
        String placaVehiculo,
        String cedulaConductor,
        LocalDateTime fechaIngreso,
        LocalDateTime fechaSalida,
        long horasFacturadas,
        double tarifaHora,
        double descuentoAplicado,
        double valorTotal
) { }
