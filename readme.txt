## Docker DB MySQL

### Image
docker build -t mysql-image -f docker/db/Dockerfile .

### Container
docker run -d -v $(pwd)/docker/db/data:/var/lib/mysql -p 3307:3306 --rm --name mysql-container mysql-image

### Initial
docker exec -i mysql-container mysql -uroot -proot < docker/db/initial.sql