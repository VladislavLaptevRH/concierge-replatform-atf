@Library('jenkins-rhapsody-libraries@master') _ //Importing shared Libraries
import com.rh.rhapsody.*;

Service s = Service.CONCIERGE_REPLATFORM_ATF;

def resultspath = "${env.JOB_NAME}/${env.BUILD_NUMBER}"
println("resultspath=${resultspath}")

Java11Pipeline pipeline = new Java11Pipeline(this, s, env);
pipeline.standardTemplate { label ->
    properties([parameters([choice(choices: ['stg2', 'stg3', 'stg4', 'prod'], description: 'Select Environment to build', name: 'ENVIRONMENT'), choice(choices: ['prodsupport', 'search', 'searchdev'], description: 'Select optional endpoint value', name: 'ENDPOINT')])])
    node(label) {

        try {
            stage('checkout') {
                pipeline.checkoutCode();
                echo "Regression will be done on environment ${params.ENVIRONMENT}"
                environment "${params.ENVIRONMENT}"
            }


            stage('Run Tests') {
                pipeline.buildMvn("clean test -Dcucumber.filter.tags='@conciergeRegression'", true);
            } // end stage

            container("awscli") {
                withAWS(region: "us-east-1", role: "devops-documentation", roleAccount: "487531406788") {
                    dir(s.rootDirectory) {
                        sh """
                        apk --no-cache add tree
                        pwd 
                        cd /home/jenkins/workspace/eCommerce/concierge-replatform-atf/target
                        tree -H '.' -L 3 --noreport --charset utf-8  -o index.html
                        aws s3 sync . s3://docs.rhapsody.rh.com/public/${resultspath}
                        """
                    } // pipeline dir
                }
            }  // pipeline/container

            slackSend(color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL}) 'Environment' (${params.ENVIRONMENT }) 'Endpoint' (${params.ENDPOINT })  : Test Results: http://docs.rhapsody.rh.com/public/${resultspath}/cucumber-html-report/Index.html", channel: "#test-results")
        } catch (Exception exception) {
            notifyFailed()
            throw exception;
        }
    } // end Node
} // pipelineTemplate

def notifyFailed() {
    slackSend(color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})", channel: "#test-results")
}


