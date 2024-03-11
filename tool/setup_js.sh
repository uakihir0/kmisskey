#!/usr/bin/env bash
cd "$(dirname "$0")" || exit
BASE_PATH=$(pwd)
BUILD_PATH=../build

# Make Ignore Files
cd "$BASE_PATH" || exit
cd $BUILD_PATH/js/packages/kmisskey-pods || exit
touch .gitignore
echo "node_modules" >> .gitignore
touch .npmignore
echo "node_modules" >> .npmignore

# Copy README
cd "$BASE_PATH" || exit
cd ../ || exit
cp ./LICENSE ./build/js/packages/kmisskey-pods/LICENSE
cp ./docs/js/README.md ./build/js/packages/kmisskey-pods/README.md
cp ./docs/js/README_ja.md ./build/js/packages/kmisskey-pods/README_ja.md
