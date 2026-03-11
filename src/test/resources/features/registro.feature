Feature: Flujo completo de pedido en restaurante
  Como usuario, quiero realizar un pedido completo en el restaurante, desde la selección de una mesa hasta la confirmación del pedido, para disfrutar de una experiencia fluida y satisfactoria.

  Scenario Outline: Realizar un pedido completo en el restaurante
    Given el usuario accede a la página de mesas disponibles
      And selecciona una mesa con estado "disponible"
    When el usuario es redirigido a la página del menú
      And agrega productos al carrito seleccionando la cantidad deseada para cada uno
      And revisa el carrito de compras y elimina los productos no deseados
      And añade notas adicionales a los productos que lo requieran
      And confirma el pedido desde la página del carrito
    Then el pedido es generado y enviado correctamente
      And el usuario es redirigido a la página de confirmación del pedido
      And el usuario visualiza el mensaje de confirmación junto con el ID del pedido

    Examples:
      | mesa_id | producto_1       | cantidad_1 | producto_2       | cantidad_2 | producto_3       | cantidad_3 |
      | 101     | Hamburguesa      | 2          | Papas fritas     | 1          | Refresco         | 2          |
      | 102     | Ensalada César   | 1          | Sopa de tomate   | 1          | Agua mineral     | 1          |