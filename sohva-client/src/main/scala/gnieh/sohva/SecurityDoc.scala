/*
* This file is part of the sohva project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*couch.http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package gnieh.sohva

/** A security document is a special document for couchdb. It has no `_id` or
 *  `_rev` field.
 *
 *  @author Lucas Satabin
 */
case class SecurityDoc(admins: SecurityList = EmptySecurityList, members: SecurityList = EmptySecurityList)

case class SecurityList(names: List[String] = Nil, roles: List[String] = Nil)
object EmptySecurityList extends SecurityList()
