// SPDX-License-Identifier: Apache-2.0
//
// Copyright (c) 2019 Intel Corporation
// Copyright (c) 2020 The Linux Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * This global var is a drop-in replacement for "parallel{}" code blocks, which
 * will process the parellel code as expected, while also capturing job cost
 * data for all nodes used, and passing it to the main node as a stack-cost
 * file.
 *
 * @param body A code block structured in the form of a pipeline "parallel"
 * block.
 */
def call(body) {
    return(parallel{body})
}
