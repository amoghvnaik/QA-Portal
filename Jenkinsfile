pipeline{
        agent any
        
        stages{
		stage('--building--'){
			steps{
				sh '''ssh deployment << EOF
				      cd QA-Portal/qa-portal-services/
                                      git pull
				      git checkout week12-week3-frontend
				      mvn clean install
				      docker-compose build
				      docker-compose push
                                      kubectl apply -f kubectl.yaml
				      EOF
				      '''
			}
		}
        }
}
