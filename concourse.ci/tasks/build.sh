#!/bin/bash

set -e -x

pushd pcfdemo
  bundle install
  bundle exec rspec
popd