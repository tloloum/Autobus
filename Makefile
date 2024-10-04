# Makefile for your project

# Compiler and flags
JAVAC = javac
JAVAC_FLAGS = -d build -cp src

# Directories
SRC_DIR = src
TEST_DIR = tst
BUILD_DIR = build

# List of Java source files
JAVA_FILES = $(shell find $(SRC_DIR) -type f -name "*.java")

# List of test Java source files
TEST_FILES = $(shell find $(TEST_DIR) -type f -name "*.java")

# List of class files (derived from all Java source files)
CLASS_FILES = $(JAVA_FILES:$(SRC_DIR)/%.java=$(BUILD_DIR)/%.class)
TEST_CLASS_FILES = $(TEST_FILES:$(TEST_DIR)/%.java=$(BUILD_DIR)/%.class)

# Main targets
all: srccompile tstcompile

# Compile Java source files into class files
srccompile: $(CLASS_FILES)

$(BUILD_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) $(JAVAC_FLAGS) $<

# Compile test Java source files into class files
tstcompile: $(TEST_CLASS_FILES)

$(BUILD_DIR)/%.class: $(TEST_DIR)/%.java
	$(JAVAC) $(JAVAC_FLAGS) $<

# Run all unit tests
test: $(TEST_CLASS_FILES)
	@echo "Running unit tests..."
	@for test in build/tec/*Test*.class; do \
		if ! echo "$$test" | grep -q '\$$'; then \
			class_name=`echo $$test | sed 's/build\///' | sed 's/\.class//' | tr '/' '.'`; \
			echo "Running $$class_name"; \
			java -ea -cp build $$class_name; \
		fi; \
	done
	@for test in build/clc/*Test*.class; do \
		if ! echo "$$test" | grep -q '\$$'; then \
			class_name=`echo $$test | sed 's/build\///' | sed 's/\.class//' | tr '/' '.'`; \
			echo "Running $$class_name"; \
			java -ea -cp build $$class_name; \
		fi; \
	done



recette:
	$(JAVAC) $(JAVAC_FLAGS) $(wildcard src/recette/Simple*.java)
	java -cp build SimpleStandard
	java -cp build SimpleStresse
	java -cp build SimpleIndecis
	java -cp build SimpleGreffonAUnMemoire
	java -cp build SimpleGreffonEstUnMemoire
	java -cp build SimpleGreffonAUnFichier
	java -cp build SimpleGreffonEstUnFichier


# Clean up
clean:
	rm -rf $(BUILD_DIR)

.PHONY: all srccompile tstcompile recette test clean
