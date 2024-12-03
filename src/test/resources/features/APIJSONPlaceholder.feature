@JSONPlaceholder
Feature: API JSONPlaceholder
  Como un usuario de la API JSONPlaceholder
  Quiero interactuar con los posts disponibles
  Para consultar y crear publicaciones

  @CP01
  Scenario: Obtener un post por ID exitosamente
    Given el actor establece el endpoint para obtener un post por ID
    When el actor envía una solicitud GET con el ID "1"
    Then el codigo de respuesta deberia ser 200

  @CP02
  Scenario Outline: Crear un post exitosamente
    Given el actor establece el endpoint POST para crear un post
    When el actor envía una solicitud HTTP POST con el "title" "body" "userId"
    Then el codigo de respuesta deberia ser 201
    Examples:
      | title        | body                      | userId |
      | Primer post  | Este es el contenido      | 1      |
      | Segundo post | Detalle de la publicación | 2      |
