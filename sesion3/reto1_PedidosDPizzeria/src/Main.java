import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<pedido> pedidos = List.of(
                new pedido("Luis", "domicilio", "555-1234"),
                new pedido("Ana", "local", "555-9999"),
                new pedido("Carlos", "domicilio", null),
                new pedido("Elena", "domicilio", "555-5678"),
                new pedido("Jorge", "local", null)
        );

        pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                .map(pedido::getTelefono)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(tel -> "📞 Confirmación enviada al número: " + tel)
                .forEach(System.out::println);
    }
}
