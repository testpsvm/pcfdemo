
# Concourse.ci steps

## Install and configure concourse.ci 



## Login to the concourse server


Open the pcfdemo folder

`fly -t lite login -c http://<url_of_concourse_srv>:<concourse_server_port>`

__ Remark __ the concourse default port is 8080

Then fill the user / password to connect to concourse server.



`fly -t lite set-pipeline -p pcfdemo -c concourse.ci/pipeline.yml -l concourse.ci/pipeline-properties.yml`