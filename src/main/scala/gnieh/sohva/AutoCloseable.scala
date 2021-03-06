/*
* This file is part of the sohva project.
* Copyright (c) 2016 Lucas Satabin
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

import java.io.Closeable

class AutoCloseabled[T <: Closeable](closeable: T) {

  def flatMap[U <: Closeable](f: T => AutoCloseabled[U]): AutoCloseabled[U] =
    f(closeable)

  def foreach(f: T => Unit): Unit =
    try {
      f(closeable)
    } finally {
      closeable.close()
    }

}
