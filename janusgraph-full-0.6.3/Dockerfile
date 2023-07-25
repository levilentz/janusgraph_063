FROM alpine:latest

RUN apk add openjdk11 bash
RUN apk --no-cache add procps

RUN mkdir /app

COPY . /app

WORKDIR /app

CMD ["bash", "docker-entrypoint.sh"]
