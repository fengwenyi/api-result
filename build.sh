#!/bin/bash
mvn clean deploy -P sonatype-oss-release -DskipTests
git tag -a 2.5.1 -m 'v2.5.1'
git push origin 2.5.1
