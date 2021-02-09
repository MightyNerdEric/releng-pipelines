def call() {
    sh(script: libraryResource('shell/job-cost.sh'))
    cost_str = sh(script: "cat $WORKSPACE/archives/cost.csv | cut -d, -f6", returnStdout: true)

    try {
        unstash "stack-cost"
        stack_cost = sh(script: "cat stack-cost | awk '{print \$2}", returnStdout: true)
    } catch(groovy.lang.MissingPropertyException e) {
        stack_cost = 0
    }

    cost = (cost_str as float) + (stack_cost as float)
    sh("echo total: ${cost} > stack-cost")
    stash includes: "**/stack-cost", name: "stack-cost"
}
