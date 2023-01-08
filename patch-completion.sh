#/bin/bash
# patch the shell completion script `hsmcli_completion` generated by picocli
# to support dynamic option completion for key algorithms
# replace the line containing
#   "local algorithm_option_args="
# by this line
#   '  local algorithm_option_args=($(${COMP_WORDS[0]} key-algorithms))'

sed -i 's/^.*local algorithm_option_args=.*$/  local algorithm_option_args=($(${COMP_WORDS[0]} key-algorithms))/g' hsmcli_completion