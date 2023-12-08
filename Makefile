test:
	./mvnw test

test-class:
	./mvnw test -Dtest=${class}

run:
	./mvnw spring-boot:run

build:
	./mvnw clean package

install:
	./mvnw clean install -DskipTests

test-unit:
	./mvnw test -Dtest=UnitTestSuite

generate-openapi:
	@echo Generating $* spec...
	@docker run --rm --user ${UID}:${GID} -v "${PWD}/src/main/resources/openapi:/spec" openapitools/openapi-generator-cli:latest generate -i /spec/discogs-v1-openapi.yml -g openapi-yaml -o /spec/output/openapi.yml
	@echo ""
	@echo "🪄 Spec $* has been generated"
