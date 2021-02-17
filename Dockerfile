FROM gradle:6.8.2-jdk8

EXPOSE 7000

ADD /build/libs/Currency.jar /opt/src/currency/Currency.jar
WORKDIR /opt/src/Currency.jar
ENTRYPOINT exec java $JAVA_OPTS -jar /opt/src/currency/Currency.jar