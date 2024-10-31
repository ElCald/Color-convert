#
# MAIN CONFIGURATION
# Author makefile : Cyril Rabat
#

EXEC = main
OBJECTS = color_convert.cpp
PROJECT_NAME = Color converter

#
# SUFFIXES
#

.SUFFIXES: .cpp .o

#
# OBJECTS
#

EXEC_O = $(EXEC:=.o)
OBJECTS_O = $(OBJECTS) $(EXEC_O)

#
# ARGUMENTS AND COMPILER
#

CC = g++
CCFLAGS_STD = -Wall -Wextra #-Werror
CCFLAGS_DEBUG = -D _DEBUG_
CCFLAGS = $(CCFLAGS_STD)
CCLIBS = -lopencv_core -lopencv_imgcodecs -lopencv_highgui -lopencv_imgproc


#
# RULES
#


all: msg $(OBJECTS) $(EXEC_O)

	@echo "Compilation classique"
	@echo "Create executables..."
	@for i in $(EXEC); do \
	$(CC) -o $$i $$i.o $(OBJECTS) $(CCLIBS); \
	done
	@echo "Done."


omp: msg $(OBJECTS) $(EXEC_O)

	@echo "Compilation avec OpenMP"
	@echo "Create executables..."
	@for i in $(EXEC); do \
	$(CC) -fopenmp -o $$i $$i.cpp $(OBJECTS) $(CCLIBS); \
	done
	@echo "Done."


msg:
	@echo "Create objects..."

debug: CCFLAGS = $(CCFLAGS_STD) $(CCFLAGS_DEBUG)
debug: all

#
# DEFAULT RULES
#

%.o : %.cpp
	@cd $(dir $<) && ${CC} ${CCFLAGS} -c $(notdir $<) -o $(notdir $@)

#
# GENERAL RULES
#

clean:
	@echo "Delete objects, temporary files..."
	@rm -f $(OBJECTS) $(EXEC_O)
	@rm -f *~ *#
	@rm -f $(EXEC)
	@rm -f dependancies
	@echo "Done."

depend:
	@echo "Create dependancies..."
	@sed -e "/^# DEPENDANCIES/,$$ d" makefile > dependancies
	@echo "# DEPENDANCIES" >> dependancies
	@for i in $(OBJECTS_O); do \
	$(CC) -MM -MT $$i $(CCFLAGS) `echo $$i | sed "s/\(.*\)\\.o$$/\1.cpp/"` >> dependancies; \
	done
	@cat dependancies > makefile
	@rm dependancies
	@echo "Done."

#
# CREATE ARCHIVE
#

ARCHIVE_FILES = *

archive: clean
	@echo "Create archive $(PROJECT_NAME)_$(shell date '+%y%m%d.tar.gz')..."
	@REP=`basename "$$PWD"`; cd .. && tar zcf $(PROJECT_NAME)_$(shell date '+%y%m%d.tar.gz') $(addprefix "$$REP"/,$(ARCHIVE_FILES))
	@echo "Done."

# DEPENDANCIES
color_convert.o: color_convert.cpp color_convert.h
main.o: main.cpp color_convert.h
