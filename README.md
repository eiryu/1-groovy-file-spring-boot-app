# 1 Groovy file Spring Boot App

### run 

```bash
$ spring --version
Spring CLI v2.0.2.RELEASE

$ spring jar app.jar *.groovy
$ java -jar app.jar
```


### run(Docker)

```bash
$ docker build -t sample .
$ docker run -it --rm -e 'PORT=8080' -p 8080:8080 sample
```


### run(Heroku)

```bash
$ heroku create 
$ heroku container:push web
$ heroku container:release web
```


### run(Deis)

```bash
$ deis create 
$ deis config:set PORT=8080
$ git push deis master
```
