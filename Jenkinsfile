pipeline{
        agent any
        
        stages{ 
                stage('---Update Images---'){
                        steps{
                                sh '''export build="${BUILD_NUMBER}"
				      git checkout deploy-stack
				      docker system prune -af
				      mvn clean install -DskipTests
				      docker-compose up -d --build
				      docker-compose down --volumes
				      docker-compose push
                                      '''
                        }
                }
                stage('---Update Containers---'){
                        steps{
                                sh '''ssh assassin-ansible-deploy << EOF
				      export build="${BUILD_NUMBER}"
				      git checkout deploy-stack
				      docker system prune -f
				      docker stack deploy --compose-file qa-portal/docker-compose.yaml qa-portal
				      EOF
                                      '''
                        }
                }
	}
}
