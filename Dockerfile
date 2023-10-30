FROM openjdk:17-jdk-slim

COPY docker /opt/billing
COPY target/Billing-0.0.1-SNAPSHOT.jar /opt/billing/Billing-0.0.1-SNAPSHOT.jar

RUN ["chmod", "+x", "/opt/billing/entrypoint.sh"]

ENTRYPOINT ["./opt/billing/entrypoint.sh"]
