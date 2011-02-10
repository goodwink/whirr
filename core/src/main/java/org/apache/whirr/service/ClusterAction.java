/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.whirr.service;

import java.io.IOException;

import org.jclouds.compute.ComputeServiceContextFactory;

/**
 * Performs an action on a cluster. Example actions include bootstrapping
 * (launching, creating), configuring, or running an arbitrary command on the
 * cluster.
 */
public abstract class ClusterAction {
  
  private final ComputeServiceContextFactory computeServiceContextFactory;

  protected ClusterAction(final ComputeServiceContextFactory computeServiceContextFactory) {
    this.computeServiceContextFactory = computeServiceContextFactory;
  }
  
  protected ComputeServiceContextFactory getComputeServiceContextFactory() {
    return computeServiceContextFactory;
  }
  
  protected abstract String getAction();

  public abstract Cluster execute(ClusterSpec clusterSpec, Cluster cluster)
      throws IOException, InterruptedException;
  
}
