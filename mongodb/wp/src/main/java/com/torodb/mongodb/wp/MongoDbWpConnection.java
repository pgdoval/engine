/*
 * ToroDB
 * Copyright © 2014 8Kdata Technology (www.8kdata.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.torodb.mongodb.wp;

import com.torodb.mongowp.commands.Connection;


/**
 *
 */
public class MongoDbWpConnection implements Connection {

  private final int id;

  public MongoDbWpConnection(int id) {
    this.id = id;
  }

  @Override
  public int getConnectionId() {
    return id;
  }

  @Override
  public void close() {
  }

}
