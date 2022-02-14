@Library('jenkins-rhapsody-libraries@master') _ //Importing shared Libraries
import com.rh.rhapsody.*;

rhapsodyUtils.standardPipelineProperties();

Service s = Service.CONCIERGE_REPLATFORM_ATF;

Java11Pipeline pipeline = new Java11Pipeline(this, s, env);

pipeline.standardTemplate { label ->

    node(label) {

        stage ('Init') {
            pipeline.checkoutCode()
        }
        stage('Public Maven') {
            pipeline.buildMvn("test");
        } // end stage
    } // end Node
} // pipelineTemplate
