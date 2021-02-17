FROM gradle:6.8.2-jdk8

EXPOSE 7000

ADD run.sh /opt/currency/run.sh
WORKDIR /opt/run.sh
ENTRYPOINT ["/opt/currency/run.sh"]