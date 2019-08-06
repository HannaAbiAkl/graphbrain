from graphbrain.meaning.corefs import main_coref


def is_actor(hg, edge):
    if edge.type()[0] == 'c':
        return hg.exists(('actor/p/.', main_coref(hg, edge)))
    else:
        return False


def find_actors(hg, edge):
    actors = set()
    if is_actor(hg, edge):
        actors.add(main_coref(hg, edge))
    if not edge.is_atom():
        for item in edge:
            actors |= find_actors(hg, item)
    return actors