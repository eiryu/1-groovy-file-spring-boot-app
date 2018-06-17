FROM groovy:2.5.0-jdk8

COPY . /home/groovy
WORKDIR /home/groovy

CMD ["/home/groovy/run.sh"]
