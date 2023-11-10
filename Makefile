test:
	./mvnw test

test-class:
	./mvnw test -Dtest=${class}

run:
	./mvnw spring-boot:run

build:
	./mvnw clean package

install:
	./mvnw clean install

test-unit:
	./mvnw test -Dtest=UnitTestSuite
