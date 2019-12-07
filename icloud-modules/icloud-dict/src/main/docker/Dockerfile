#VERSION EE:latest
FROM livingobjects/jre8
MAINTAINER lishangzhi "13680348517@163.com"
VOLUME /tmp
ADD icloud-dict.jar /usr/local/icloud-dict.jar
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
#\u914d\u7f6eJAVA_OPTIONS
ENV JAVA_OPTIONS "-Xms1024M \
                  -Xmx1024M \
                  -Xmn512M \
                  -XX:SurvivorRatio=8 \
                  -XX:MaxTenuringThreshold=7 \
                  -XX:GCTimeRatio=19 \
                  -Xnoclassgc \
                  -XX:+DisableExplicitGC \
                  -XX:+UseParNewGC \
                  -XX:+UseConcMarkSweepGC \
                  -XX:+CMSPermGenSweepingEnabled \
                  -XX:+UseCMSCompactAtFullCollection \
                  -XX:CMSFullGCsBeforeCompaction=0 \
                  -XX:+CMSClassUnloadingEnabled \
                  -XX:-CMSParallelRemarkEnabled \
                  -XX:CMSInitiatingOccupancyFraction=70 \
                  -XX:SoftRefLRUPolicyMSPerMB=0 \
                  -XX:+PrintClassHistogram \
                  -XX:+PrintGCDetails \
                  -XX:+PrintGCTimeStamps \
                  -XX:+PrintGCApplicationConcurrentTime \
                  -XX:+PrintGCApplicationStoppedTime \
                  -Xloggc:/logs/icloud-dict.log"
ENTRYPOINT java ${JAVA_OPTIONS} -Djava.security.egd=file:/dev/./urandom -jar /usr/local/icloud-dict.jar
