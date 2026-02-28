pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk17'
    }

    environment {
        TOMCAT_HOME = "/opt/tomcat"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                dir('prac9') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Run Tests') {
            steps {
                dir('prac9') {
                    sh 'mvn test'
                }
            }
        }

        stage('Stop Tomcat') {
            steps {
                sh '$TOMCAT_HOME/bin/shutdown.sh || true'
                sh 'sleep 5'
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                dir('prac9') {
                    sh '''
                    rm -f $TOMCAT_HOME/webapps/prac9-1.0-SNAPSHOT.war
                    cp target/*.war $TOMCAT_HOME/webapps/
                    '''
                }
            }
        }

        stage('Start Tomcat') {
            steps {
                sh '$TOMCAT_HOME/bin/startup.sh'
            }
        }
    }

    post {
        success {
            echo "Application Deployed Successfully!"
        }
        failure {
            echo "Build Failed!"
        }
    }
}
