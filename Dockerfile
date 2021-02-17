FROM gradle:6.8.2-jdk8

EXPOSE 7000

ADD /build/libs/Currency.jar /opt/currency/Currency.jar
ADD run-prd.sh /opt/currency/run-prd.sh
WORKDIR /opt/run-prd.sh
ENTRYPOINT ["/opt/currency/run-prd.sh"]