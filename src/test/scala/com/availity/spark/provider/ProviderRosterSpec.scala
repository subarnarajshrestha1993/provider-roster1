package com.availity.spark.provider

import com.github.mrpowers.spark.fast.tests.DataFrameComparer
import org.scalatest.BeforeAndAfterEach
import org.scalatest.funspec.AnyFunSpec

class ProviderRosterSpec extends AnyFunSpec with DataFrameComparer with BeforeAndAfterEach {

  override def beforeEach: Unit = {
  }

  override def afterEach(): Unit = {
  }

  describe("process") {
    it("should run a test") {
      ProviderRoster.process()
    }
  }
}
