@Library('jenkins-rhapsody-libraries@selenium') _ //Importing shared Libraries
import com.rh.rhapsody.*;

rhapsodyUtils.standardPipelineProperties();

Service s = Service.CONCIERGE_REPLATFORM_ATF;

SeleniumPipeline pipeline = new SeleniumPipeline(this, s, env);
pipeline.standardTemplate { label ->
    node(label) {
    try {
      stage ('checkout') {
          pipeline.checkoutCode();
      }
      
      stage('test') {
          pipeline.runTest();
      }
    } // end Node
} // pipelineTemplate
