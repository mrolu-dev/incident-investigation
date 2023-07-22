pipeline {
    agent any

    stages {
        stage('Build Incident Service') {
            steps {
                dir('incident-investigation/incident-service') {
                    script {
                        docker.build("incident-service:${env.BUILD_ID}")
                    }
                }
            }
        }

        stage('Build SCAT Analysis Service') {
            steps {
                dir('incident-investigation/scat-analysis-service') {
                    script {
                        docker.build("scat-analysis-service:${env.BUILD_ID}")
                    }
                }
            }
        }

        stage('Run Tests') {
            steps {
                dir('incident-investigation/incident-service') {
                    sh 'mvn test'
                }
                dir('incident-investigation/scat-analysis-service') {
                    sh 'mvn test'
                }
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down'
        }
    }
}
