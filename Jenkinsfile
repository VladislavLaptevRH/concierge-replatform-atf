@Library('jenkins-rhapsody-libraries@master') _ //Importing shared Libraries
import com.rh.rhapsody.*;

rhapsodyUtils.standardPipelineProperties();

Service s = Service.CONCIERGE_REPLATFORM_ATF;

"Deployment Approval (${service.id}:${environment.id}?"
def resultspath = "${s.id}/${env.JOB_NAME}/${env.BUILD_NUMBER}"
println("resultspath=${resultspath}")

Java11Pipeline pipeline = new Java11Pipeline(this, s, env);
pipeline.standardTemplate { label ->
    node(label) {
        stage ('checkout') {
          pipeline.checkoutCode();
        }

        stage('Run Tests') {
            pipeline.buildMvn("clean test");
        } // end stage

        container("awscli") {
            withAWS(region: "us-east-1", role: "devops-documentation", roleAccount:"487531406788") {
                dir(s.rootDirectory) {
                    sh """
                    pwd 
                    cd /home/jenkins/workspace/eCommerce/concierge-replatform-atf/target/cucumber-html-report
                    aws s3 sync . s3://docs.rhapsody.rh.com/public/${resultspath}
                    """
                } // pipeline dir
            }
        }  // pipeline/container

        slackSend (color: '#00FF00',message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL}) : Test Results: http://docs.rhapsody.rh.com/public/${resultspath}/Index.html", channel: "#test-results")

    } // end Node
} // pipelineTemplate


