Feature: Flujo completo de pedido en restaurante
  Como usuario, quiero realizar un pedido completo en el restaurante, desde la seleccion de una mesa hasta la confirmacion del pedido, para disfrutar de una experiencia fluida y satisfactoria.

  Scenario Outline: Realizar un pedido completo en el restaurante
    Given el usuario accede a la pagina de mesas disponibles
      And selecciona una mesa con estado "disponible"
    When el usuario es redirigido a la pagina del menu
      And agrega productos al carrito seleccionando la cantidad deseada para cada uno
      And revisa el carrito de compras y elimina los productos no deseados
      And añade notas adicionales a los productos que lo requieran
      And confirma el pedido desde la pagina del carrito
    Then el pedido es generado y enviado correctamente
      And el usuario es redirigido a la pagina de confirmacion del pedido
      And el usuario visualiza el mensaje de confirmacion junto con el ID del pedido

    Examples:
      | order_id | table_id | status**   | product_1   | quantity_1 | product_2    | quantity_2 | product_3   | quantity_3 | total_price | confirmed_at       |
      | 1        | 11       | READY      | Hamburguesa  | 2         | Papas fritas | 1          | Refresco    | 2          | 1130        | 2026-03-10 12:30:00   |