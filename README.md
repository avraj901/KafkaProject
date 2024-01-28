>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>String Producer Local URL>>>>>>>>>>>>>>>>>>>>>>

curl --location 'http://localhost:8081/publish?message=new%20kafka%20message%20'


<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Json Producer Local URL<<<<<<<<<<<<<<<<<<<<<<<<
curl --location 'http://localhost:8081/jsonpublish' \
--header 'Content-Type: application/json' \
--data '{
    "id" : 1,
    "firstName" : "Raj",
    "lastName" : "Rajbhar"
} '
