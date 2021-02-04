float cost = 0

def addCost() {
    sh(script: libraryResource('shell/job-cost.sh'))
    cost_str = sh(script: "cat $WORKSPACE/archives/cost.csv | cut -d, -f6", returnStdout: true)
    cost += cost_str as float
}

def getCost() {
    return cost
}

def writeStackCost() {
    sh("echo total: ${cost} > stack-cost")
}
