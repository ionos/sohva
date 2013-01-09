/*
* This file is part of the sohva project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package gnieh.sohva
package test

import sync._
import liftjson.serializer

import org.scalatest._

/** Code to be executed before and after each test */
abstract class SohvaTestSuite extends FlatSpec with BeforeAndAfterAll {

  val couch = new CouchClient
  val session = couch.startSession

  val db = session.database("sohva-tests")

  override def beforeAll() {
    // login
    session.login("admin", "admin")
    // create database
    db.create
  }

  override def afterAll() {
    // cleanup database
    db.delete
    // logout
    session.logout
    // shutdown client
    couch.shutdown
  }

}

case class TestDoc(_id: String, toto: Int)(val _rev: Option[String] = None)