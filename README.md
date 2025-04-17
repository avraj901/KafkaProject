1.String Producer Local URL

curl --location 'http://localhost:8081/publish?message=new%20kafka%20message%20'


2.<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Json Producer Local URL<<<<<<<<<<<<<<<<<<<<<<<<
curl --location 'http://localhost:8081/jsonpublish' \
--header 'Content-Type: application/json' \
--data '{
    "id" : 1,
    "firstName" : "Raj",
    "lastName" : "Rajbhar"
} '


3. curl --location 'http://localhost:8081/api/v1/orders' \
--header 'Content-Type: application/json' \
--data '{

    "name":"avanish"
}'
