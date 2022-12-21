pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "sp-maven"
    }

    stages {
        stage("Checkout Step"){
            steps{
                checkout(
                    [
                        $class: 'GitSCM', 
                        branches: [[name: '*/main']], 
                        extensions: [], 
                        userRemoteConfigs: [
                            [
                                credentialsId: 'git-hub-pt0ken', 
                                url: 'https://github.com/sasiperi/sasiperi-springboot-15factor-app-labs'
                            ]
                        ]
                    ]
            )

        }
            
        }

        stage('Build') {
            steps {
                /*
                   dir('asiperi-springboot-15factor-app-labs') {
                        // some block
                   } 

                */

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'springboot-app-final/target/*.jar'
                }
            }
        }
    }
}

