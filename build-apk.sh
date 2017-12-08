#!/bin/bash
set -x
sudo fastlane unit_tests
sudo fastlane build_debug