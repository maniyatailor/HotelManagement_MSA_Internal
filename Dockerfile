FROM ivonet/payara:5.2022.2-jdk17
#FROM ivonet/payara:5.2022.2-jdk11
#FROM payara/server-full:5.2022.2-jdk11
COPY ./artifact/HotelApplication.war $DEPLOY_DIR
