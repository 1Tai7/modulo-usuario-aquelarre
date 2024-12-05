DOCUMENTACION: 
`http://localhost:8080/doc/swagger-ui/index.html`


USUARIO
GET:
`curl --location 'localhost:8080/api/v1/usuarios' `

POST: 
curl --location 'localhost:8080/api/v1/usuarios' \
--header 'Content-Type: application/json' \
--data-raw '   {
    
        "nombre": "javier",
        "alias": "mao",
        "contrasena": "asdfgh",
        "email": "jjavier@gamil.com",
        "id_rol": "2"
    }' 


DELETE:
`curl --location --request DELETE 'localhost:8080/api/v1/usuarios/3' `

POSTEO
GET: ` curl --location 'localhost:8080/api/v1/post' `

POST: 
` curl --location 'localhost:8080/api/v1/post' \
--header 'Content-Type: application/json' \
--data '{
    "id_usuario": "12",
    "hashtag": "#dolor",
    "alias": "12",
    "ocmentario": "1"
  
}' `

DELETE:
` curl --location --request DELETE 'localhost:8080/api/v1/post' `

ROL:
GET:
` curl --location 'localhost:8080/api/v1/usuarios' `
POST: 
`curl --location 'localhost:8080/api/v1/usuarios' \
--header 'Content-Type: application/json' \
--data '{
    "id_rol": "2"
}' `

DELETE:
` curl --location --request DELETE 'localhost:8080/api/v1/usuarios' `

COMENTARIO:
GET:
` curl --location 'localhost:8080/api/v1/comentarios' `

POST:
` curl --location --request POST 'localhost:8080/api/v1/comentarios' \
--data '' `

DELETE: 
` curl --location --request DELETE 'localhost:8080/api/v1/comentarios' `

GITHUB: https://github.com/1Tai7/modulo-usuario-aquelarre
