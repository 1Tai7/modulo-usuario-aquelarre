POSTMAN
GET:

 ´
 curl --location 'localhost:8080/api/v1/usuarios' 

 ´

POST: 

´
curl --location 'localhost:8080/api/v1/usuarios' \
--header 'Content-Type: application/json' \
--data-raw '   {
    
        "nombre": "javier",
        "alias": "mao",
        "contrasena": "asdfgh",
        "email": "jjavier@gamil.com",
        "id_rol": "2"
    }' 
´

DELETE:

´
curl --location --request DELETE 'localhost:8080/api/v1/usuarios/3' 

´


GITHUB: https://github.com/1Tai7/modulo-usuario-aquelarre
