/**
 * Copyright (C) 2014-2015 LinkedIn Corp. (pinot-core@linkedin.com)
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
package com.linkedin.pinot.broker.broker;

import com.linkedin.pinot.broker.broker.helix.DefaultHelixBrokerConfig;
import com.linkedin.pinot.broker.broker.helix.HelixBrokerStarter;
import org.apache.commons.configuration.Configuration;


/**
 * Utilities to start a broker during unit tests.
 *
 * @author jfim
 */
public class BrokerTestUtils {
  public static Configuration getDefaultBrokerConfiguration() {
    return DefaultHelixBrokerConfig.getDefaultBrokerConf();
  }

  public static HelixBrokerStarter startBroker(final String clusterName, final String zkStr, final Configuration configuration) {
    try {
      return new HelixBrokerStarter(clusterName, zkStr, configuration);
    } catch (Exception e){
      throw new RuntimeException(e);
    }
  }

  public static void stopBroker(final HelixBrokerStarter brokerStarter) {
    try {
      brokerStarter.getBrokerServerBuilder().stop();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}