/*
 * Copyright (C) 2017 Seoul National University
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.snu.onyx.compiler.optimizer.policy;

import edu.snu.onyx.compiler.optimizer.pass.compiletime.*;
import edu.snu.onyx.compiler.optimizer.pass.compiletime.composite.PrimitiveCompositePass;
import edu.snu.onyx.compiler.optimizer.pass.compiletime.composite.LoopOptimizationCompositePass;
import edu.snu.onyx.compiler.optimizer.pass.compiletime.composite.PadoCompositePass;
import edu.snu.onyx.runtime.common.optimizer.pass.runtime.RuntimePass;

import java.util.List;

/**
 * A policy to perform Pado optimization that uses transient resources on data centers.
 * link to paper: http://dl.acm.org/citation.cfm?id=3064181
 */
public final class PadoPolicy implements Policy {
  private final Policy policy;

  /**
   * Default constructor.
   */
  public PadoPolicy() {
    this.policy = new PolicyBuilder(true)
        .registerCompileTimePass(new PadoCompositePass())
        .registerCompileTimePass(new LoopOptimizationCompositePass())
        .registerCompileTimePass(new PrimitiveCompositePass())
        .build();
  }

  @Override
  public List<CompileTimePass> getCompileTimePasses() {
    return this.policy.getCompileTimePasses();
  }

  @Override
  public List<RuntimePass<?>> getRuntimePasses() {
    return this.policy.getRuntimePasses();
  }
}
